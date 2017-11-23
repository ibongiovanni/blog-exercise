# Blog SPA
Simple Page Application Example with API REST backend

## Information
### Frameworks used in backend
 - Maven, for project scaffolding
 - ActiveJDBC, for ORM
 - SQLite3, as DB for simplicity
 - SparkJava, for REST framework
### Framework used in frontend
 - Yeoman/webapp-generator for scaffolding
 - Gulp, for tasks automation
 - Browserify
 - Handlebars, for template rendering
 - Bootstrap v3
 - Page.js for routing
 
## Set it up
### Start Backend
1. `cd backend`
2. `mvn clean install`
3. `mvn dependency:copy-dependencies`
4. `./run.sh`

### Start Frontend
1. `cd ../frontend`
2. `npm install`
3. `bower install`
4. `gulp serve`
