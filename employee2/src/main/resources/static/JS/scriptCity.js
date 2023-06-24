console.log("This is a script file for City");

const search = () => {
  let query = $("#search-input").val().toLowerCase();

  $(".table tbody tr").each(function() {
    let city = $(this).find("td:nth-child(6)").text().toLowerCase();

    if (city.includes(query)) {
      $(this).show();
    } else {
      $(this).hide();
    }
  });
};


// Event listener for search input field

$("#search-input").on("input", search);
