

function commandManager(str){
    if(str=="open google"){window.open('http://google.com', '_blank');  return true;}
    if(str=="open facebook"){window.open('http://facebook.com', '_blank');  return true;}
    if(str=="open linkedin"){window.open('http://linkedin.com', '_blank');  return true;}
    if(str=="open twitter"){window.open('http://twitter.com', '_blank');  return true;}
    if(str=="open twitter"){window.open('http://twitter.com', '_blank');  return true;}

    var res = str.split(" ");
    if(res[0].trim()=="search")
    {window.open('https://www.google.co.in/search?q='+str.substr(str.indexOf(" ") + 1), '_blank');  return true;} 

    return false;
}