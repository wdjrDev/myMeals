package mymeals


class Ingredient {

    Integer id
    String  name
    String  description
    String  type
    String  version
    Date    dateCreated
    Date    lastUpdated

    static constraints ={
            id(nullable:false, unique: true, autoincrement:1)
            name(size:3..30,nullable:false)
            description(maxSize: 2500)
            type(size:0..30)
            version(nullable:false, size:1..5)
            dateCreated(nullable:false, default: new Date().toTimestamp())
            lastUpdated(nullable:false, default: new Date().toTimestamp())
    }
}
