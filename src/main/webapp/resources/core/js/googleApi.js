google.maps.event.addDomListener(window, 'load', function() {
    var map = new google.maps.Map(document.getElementById('map'), {
      zoom: 12,
      center: new google.maps.LatLng(56.323678, 44.0),
      mapTypeId: google.maps.MapTypeId.ROADMAP
    });

    var infoWindow = new google.maps.InfoWindow;

    var onMarkerClick = function() {
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
	  title: 'Кинотеатр КА� О ФИЛЬМ в ТЦ Шоколад',
      position: new google.maps.LatLng(56.31927,44.026297)
    });
    var marker2 = new google.maps.Marker({
      map: map,
	  title: 'Кинотеатр Октябрь',
      position: new google.maps.LatLng(56.317213,43.993976)
    });
    var marker3 = new google.maps.Marker({
      map: map,
	  title: 'Кинотеатр Синема Парк',
      position: new google.maps.LatLng(56.308056,44.073827)
    });

    google.maps.event.addListener(marker1, 'click', onMarkerClick);
    google.maps.event.addListener(marker2, 'click', onMarkerClick);
    google.maps.event.addListener(marker3, 'click', onMarkerClick);
  });