

if (navigator.geolocation) { 
  navigator.geolocation.getCurrentPosition(function(position) {  

    var point = new google.maps.LatLng(position.coords.latitude, 
                                       position.coords.longitude);

   /* var image = new google.maps.MarkerImage('./img/marker.jpg',      
      new google.maps.Size(32, 37),      
      new google.maps.Point(0,0),      
      new google.maps.Point(0, 37));
*/

    // Initialize the Google Maps API v3
    var map = new google.maps.Map(document.getElementById('map'), {
      zoom: 15,
      title: 'мое местоположение',
      center: point,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    });

     

    // Place a marker
    new google.maps.Marker({
      position: point,
      title: 'мое местоположение',
      map: map,
       
    });
  
    setMarkers(map, places);//вызов функции центрирования карты по меткам
  
    
    var infoWindow = new google.maps.InfoWindow;

   


    var onMarkerClick = function() {//функция вывода
      var marker = this;
      var latLng = marker.getPosition();
      infoWindow.setContent(marker.title);

      infoWindow.open(map, marker);
    };


    google.maps.event.addListener(map, 'click', function() {
      infoWindow.close();
    });


    var marker1 = new google.maps.Marker({
      map: map,
    title: 'РљРёРЅРѕС‚РµР°С‚СЂ РљРђР Рћ Р¤РР›Р¬Рњ РІ РўР¦ РЁРѕРєРѕР»Р°Рґ',
      position: new google.maps.LatLng(46.4395722,30.7562685)
    });
    var marker2 = new google.maps.Marker({
      map: map,
    title: 'РљРёРЅРѕС‚РµР°С‚СЂ РћРєС‚СЏР±СЂСЊ',
      position: new google.maps.LatLng(46.42691315,30.75120449)
    });
    var marker3 = new google.maps.Marker({
      map: map,
    title: 'РљРёРЅРѕС‚РµР°С‚СЂ РЎРёРЅРµРјР° РџР°СЂРє',
      position: new google.maps.LatLng(46.44412637,30.74210644)
    });
    var marker4 = new google.maps.Marker({
      map: map,
    title: 'РљРёРЅРѕС‚РµР°С‚СЂ РЎРёРЅРµРјР° РџР°СЂРє',
      position: new google.maps.LatLng(46.4369105,30.73300838)
    });

    google.maps.event.addListener(marker1, 'click', onMarkerClick);
    google.maps.event.addListener(marker2, 'click', onMarkerClick);
    google.maps.event.addListener(marker3, 'click', onMarkerClick);
    google.maps.event.addListener(marker4, 'click', onMarkerClick);
  
  }); 
} 
else {
  alert('W3C Geolocation API is not available');
}


var places = [
            ['Кинотеатр КАРО ФИЛЬМ в ТЦ Шоколад',46.4395722,30.7562685],
            ['Кинотеатр Мир',46.42691315,30.75120449],
            ['Кинотеатр Октябрь',46.44412637,30.74210644],
            ['Кинотеатр Орленок',46.4369105,30.73300838],
    ];    
 
    function setMarkers(map, locations) {
    //Определяем область показа маркеров
    var latlngbounds = new google.maps.LatLngBounds();  
         for (var i = 0; i < places.length; i++) {
            var myLatLng = new google.maps.LatLng(locations[i][1], locations[i][2]);
      //Добавляем координаты маркера в область
      latlngbounds.extend(myLatLng);
            var marker = new google.maps.Marker({
                position: myLatLng,
                map: map,   
                title: locations[i][0],
            }); 
         }
  //Центрируем и масштабируем карту
  map.setCenter( latlngbounds.getCenter(), map.fitBounds(latlngbounds));   
    };