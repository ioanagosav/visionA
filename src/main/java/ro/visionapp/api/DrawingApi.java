package ro.visionapp.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.cloud.vision.v1.*;

import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors;
import org.apache.commons.io.IOUtils;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.MediaType;

@Path("/drawing")
public class DrawingApi {

    private static final Logger LOG = Logger.getLogger(DrawingApi.class.getName());

    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public void saveDrawing(@FormDataParam("file") InputStream file
                            //, @FormDataParam("file") FormDataContentDisposition fileDetail
    ) {
        //get logged in user using userService, put it in UserDTo, save it with userdao
//        Storage storage = StorageOptions.getDefaultInstance().getService();
//        String bucketName = AppIdentityServiceFactory.getAppIdentityService().getDefaultGcsBucketName();
//        String fileName = "test" + Math.floor(Math.random() * 100);
//
//        Blob blob =
//                storage.create(
//                        BlobInfo.newBuilder(bucketName, fileName).build(),
//                        file);


        //Instantiates a client
        try {
            ImageAnnotatorClient vision = ImageAnnotatorClient.create();
            // The path to the image file to annotate

            // Reads the image file into memory
            byte[] data = IOUtils.toByteArray(file);
            ByteString imgBytes = ByteString.copyFrom(data);

            // Builds the image annotation request
            List<AnnotateImageRequest> requests = new ArrayList<>();
            Image img = Image.newBuilder().setContent(imgBytes).build();
            Feature feat = Feature.newBuilder().setType(Feature.Type.LABEL_DETECTION).build();
            AnnotateImageRequest request = AnnotateImageRequest.newBuilder()
                    .addFeatures(feat)
                    .setImage(img)
                    .build();
            requests.add(request);

            // Performs label detection on the image file
            BatchAnnotateImagesResponse response = vision.batchAnnotateImages(requests);
            List<AnnotateImageResponse> responses = response.getResponsesList();

            for (AnnotateImageResponse res : responses) {
                if (res.hasError()) {
                    LOG.warning(res.getError().getMessage());
                    return;
                }


                for (EntityAnnotation annotation : res.getLabelAnnotationsList()) {
//                    annotation.getAllFields().forEach((k, v) ->
//                            System.out.printf("%s : %s\n", k, v.toString()));
                    Map<Descriptors.FieldDescriptor, Object> map = annotation.getAllFields();

                    for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : map.entrySet()) {
                        //System.out.println(entry.getKey() + "/" + entry.getValue());
                        LOG.info("" + entry.getKey() + " " + entry.getValue());
                    }


                }
            }
        } catch (Exception e) {
            LOG.warning(e.getMessage());
            LOG.log(Level.SEVERE, "ERROR", e);
        }
    }


}
