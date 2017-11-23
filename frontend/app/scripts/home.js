export default function (ctx) {
  $.get('http://localhost:4567/', function (res) {
    console.log('res',res);
    var html = Blog.templates.home(res);
    $('#content').html(html);
  });
}