package am.aca;

public class Course {

    private String name;

    private String code;
    
    //TODO constructor
    public Course (String name,String code){
    	this.name = name;
    	this.code = code;
    }

    
    //TODO getters
    public String getName(){
    	return this.name;
    }
    public String getCode(){
    	return this.code;
    }

}