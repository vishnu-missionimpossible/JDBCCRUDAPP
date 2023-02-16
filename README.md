# JDBCCRUDAPP

Fully fledged layered application with a design pattern(Factory design) with respect to console based application 
with hikari cp connection pooling mechanism

HikariCp will establish a logical connection instead of physical connection. In order to work on this, 3 jars we need to configure in the build path.

1. We have built a java console based project that perform CRUD operations on database.
2. We will transfer the dto(data transfer object) from layer to layer. (Controller->Service->DAO) 
3. Persistence logic will  be written in the DAO layer.
4. We will follow POJI-POJO approach(plain old java interface- plain old java object)
