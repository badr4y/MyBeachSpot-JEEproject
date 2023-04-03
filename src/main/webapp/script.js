// Initialize and add the map
function initMap() {
    // The location of the center of the map
    const center = { lat: 37.7749, lng: -122.4194 };
    // The map, centered at the center location
    const map = new google.maps.Map(document.getElementById("map"), {
      zoom: 10,
      center: center,
    });
  
    // Add markers to the map
    const markers = [
      {
        position: { lat: 37.7749, lng: -122.4194 },
        title: "San Francisco",
        description: "A beautiful city by the bay",
      },
      {
        position: { lat: 34.0522, lng: -118.2437 },
        title: "Los Angeles",
        description: "The city of Angels",
      },
      {
        position: { lat: 40.7128, lng: -74.006 },
        title: "New York",
        description: "The Big Apple",
      },
    ];
  
    // Loop through markers and add to map
    for (let i = 0; i < markers.length; i++) {
      const marker = new google.maps.Marker({
        position: markers[i].position,
        map: map,
        title: markers[i].title,
      });
  
      // Add info window to each marker
      const infowindow = new google.maps.InfoWindow({
        content: markers[i].description,
      });
  
      marker.addListener("click", () => {
        infowindow.open(map, marker);
      });
    }
  }
  