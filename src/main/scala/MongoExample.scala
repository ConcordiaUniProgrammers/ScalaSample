package main.scala

import com.mongodb.casbah.MongoConnection
import com.mongodb.casbah.MongoClient
import com.mongodb.casbah.gridfs.Imports._
import java.io.FileInputStream
import com.mongodb.casbah.commons.MongoDBObject
import org.apache.logging.log4j.LogManager

/**
 * It is a sample to save an object in mongoDB, and save the onject's image 
 * in GridFs with objectId. furthermore Log4j was used in this example
 *  
 * @author Mojtaba
 */
case class Person(id: String, name: String, Family: String){
  
}
object MongoExample {

  val log = LogManager.getLogger(getClass().getName())
  val mongoConnection = MongoClient("localhost")("ScalaSample");
  
  def main(args: Array[String]) {
    try {
    	 val person = new Person("12","mojtaba"," Faramarzi")
    	 savePerson(person)
    	 log.info("person was save in people collection")
    	 
    	 saveImage("src/main/resources/image.jpg", person)
    	 log.info("person's image was save in GridFs of people with image name : {}",person.id)
    	 
    	 getImage("src/main/resources/image-copy.jpg", person)
    	 log.info("person's with id : {} was save in resources", person.id)
      
    }catch {
    	case exp: Exception => log.error(exp.getMessage())
    }
   
  }
  /**
   * @param imageAdd image source address
   * @param person person information.
   * 		we need person id to save image with person's id 
   */
  def saveImage(imageAdd: String, person: Person){
    val GFs = GridFS(mongoConnection)
    val image = new FileInputStream(imageAdd)
    val imageId = GFs(image){file =>
    	file.filename_=(person.id)
    	file.contentType_=("image/jpg")
    }
  }
  
  /**
   * @param person information that we want to store in mongoDBs
   */
  def savePerson(person: Person){
     val peopleColl = mongoConnection("People")
     val obj = MongoDBObject("id" -> person.id , "name" -> person.name , "family" -> person.Family)
     peopleColl += obj
  }
  
  /**
   * @param outputAdd place where you want to save the retrieved image
   * @param person person who need his/her image
   */
  def getImage(outputAdd: String, person: Person){
    val GFs = GridFS(mongoConnection)
    val cursor = GFs.findOne(person.id)
    val image = cursor.get
    image.writeTo(outputAdd)
  }
}
