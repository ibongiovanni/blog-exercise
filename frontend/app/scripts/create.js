import page from 'page'

export default function (ctx) {
  var html = Blog.templates.create();
  $('#content').html(html);

  $('#send-btn').on('click',function () {
    var title = $('#title').val();
    var body = $('#body').val();
    var post = {"title":title, "body":body}
    console.log('post',post);
    $.post('http://localhost:4567/admin/posts/create',JSON.stringify(post),'json')
    .done(function (res) {
      page.redirect('/');
    });
  });
}