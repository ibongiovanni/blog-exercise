import page from 'page'
import home from './home'
import create from './create'

console.log('page',page);

page('/', home)
page('/create', create)
page()

$.ajaxSetup({
  contentType: "application/json; charset=utf-8"
});