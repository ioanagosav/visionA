function getUsername(){
  const xhr = new XMLHttpRequest();
  xhr.open('GET', 'https://smth.appspot.com/rest/user', false);
  //xhr.setRequestHeader('Access-Control-Allow-Origin', '*')
  xhr.send();
  if (xhr.status === 200) {
    return(JSON.parse(xhr.response));
  } else {
    err({"message": xhr.response});
  }
}