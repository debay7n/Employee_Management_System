console.log("This is a script file for Name");

const search = () => {
  let query = $("#search-input").val().toLowerCase();

  $(".table tbody tr").each(function() {
    let name = $(this).find("td:nth-child(2)").text().toLowerCase();

    if (name.includes(query)) {
      $(this).show();
    } else {
      $(this).hide();
    }
  });
};


// Event listener for search input field

$("#search-input").on("input", search);
