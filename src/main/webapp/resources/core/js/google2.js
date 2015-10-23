var map;
	var arrMarkers = [];
	var arrInfoWindows = [];
	

	function mapInit(){

		// выводим простую карту
	   map = new google.maps.Map(document.getElementById('map'), {
	    center: {lat: 46.46720929, lng: 30.7430613},
	    zoom: 15
	  });

		

		//ќпредел€ем область отображени€ меток на карте
		var latlngbounds = new google.maps.LatLngBounds();


		//обь€вл€ем переменную кот открывает инф. окно
  		var infoWindow1 = new google.maps.InfoWindow;
		
		 //  HTML5 geolocation. - определение наших координат
		if (navigator.geolocation) {
		    navigator.geolocation.getCurrentPosition(function(position) {
		       var point = new google.maps.LatLng(position.coords.latitude, 
		                                          position.coords.longitude);
				// Place a marker
			      new google.maps.Marker({
			        position: point,
			        map: map,
			        title: 'MY Location.'
			      });
			     
			    map.setCenter(point);
	        	infoWindow1.setPosition(point);
	   			infoWindow1.setContent('MY Location.');
     
		    },
		    function() {
		      handleLocationError(true, infoWindow, map.getCenter());
		    });
		 }


		//«агружаем данные в формате JSON из файла map.json

		$.getJSON("map.json", {}, function(data){

			$.each(data.places, function(i, item){

				//$("#markers").append('<li><a href="#" rel="' + i + '">' + item.title + '</a></li>');

			
				var marker = new google.maps.Marker({
					position: new google.maps.LatLng(item.lat, item.lng),
					map: map,
					title: item.title
				});

				
				//ƒобавл€ем координаты меток
				latlngbounds.extend(new google.maps.LatLng(item.lat, item.lng));

				arrMarkers[i] = marker;

				var infowindow = new google.maps.InfoWindow({

					content: "<h3>"+ item.title +"</h3><p>"+ item.description +"</p>"

				});

				arrInfoWindows[i] = infowindow;

                google.maps.event.addListener(map, 'click', function() {
                     infoWindow.close();
                });
                
				google.maps.event.addListener(marker, 'click', function() {

					infowindow.open(map, marker);

				});



			});
			
			//÷ентрируем и масштабируем карту так, чтобы были видны все метки
			map.setCenter( latlngbounds.getCenter(), map.fitBounds(latlngbounds));

		});

	}

	/*$(function(){

		//ќпредел€ем карту (добавл€ем маркеры, балуны и список со ссылками)

		mapInit();

		

		// "live" отслеживает событие клика по ссылке

		$("#markers a").live("click", function(){

			var i = $(this).attr("rel");

			// Ёта строка кода, закрывает все открытые балуны, дл€ открыти€ выбранного

			for(x=0; x < arrInfoWindows.length; x++){ arrInfoWindows[x].close(); }

			arrInfoWindows[i].open(map, arrMarkers[i]);

		});

	});*/