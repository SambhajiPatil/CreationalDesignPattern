package CreationalDesignPatternsBuilderDesignPattern;

import CreationalDesignPatternsBuilderDesignPattern.Student.studentInner;

public class TestBuilderDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
/*     Person p = new PersonBuilder("WadaPav","Waktikde").setEntertainment("TV").build();
	*/
		
		Student st=new studentInner("yes", "Yes", "Yess").SetgoForMovie("yes").SetgoForPlay("No").build();
		System.out.println(st);
		
		Student st2=new studentInner("No", "No", "No").SetgoForYoga("yes do everday").build();
        System.out.println(st2);
        
        
        Student st3=new studentInner("yes regularlly", "Yes we Do", "Some time is required").SetgoForMovie("no").SetgoForPlay("no").SetgoForYoga("Sometime we do").build();
               System.out.println(st3);
	}

}


class Student{
	
	//mendatory
	
	String goCollege;
	String doStudy;
	String goClass;
	
	//optional
	
	String doYoga;
	String goPlay;
	String goMovie;
	
	
	
	
	public Student(studentInner studentInner) {
		this.goCollege=studentInner.goCollege;
		this.doStudy=studentInner.doStudy;
		this.goClass=studentInner.goClass;
		this.doYoga=studentInner.doYoga;
		this.goPlay=studentInner.goPlay;
		this.goMovie=studentInner.goMovie;
		
		
	}
	public String toString()
	{
		return "\n Student \n goCollege : "+goCollege+"\n doStudy : "+doStudy+"\n goClass : "+goClass+"\n doYoga : "+doYoga+"\n goPlay : "+goPlay+"\n goMovie : "+goMovie;
	}
	
	public static class studentInner{
		
		
		//mendatory
		
		String goCollege;
		String doStudy;
		String goClass;
		
		//optional
		
		String doYoga;
		String goPlay;
		String goMovie;
		
		public studentInner(String goCollege, String doStudy, String goClass) {
			super();
			this.goCollege = goCollege;
			this.doStudy = doStudy;
			this.goClass = goClass;
		}
		
		
		public studentInner SetgoForYoga(String gfy) {
			this.doYoga=gfy;
			return this;
			
		}
		
		public studentInner SetgoForPlay(String gfp) {
			this.goPlay=gfp;
			return this;			
		}
		
		public studentInner SetgoForMovie(String gfm) {
			this.goMovie=gfm;
			return this;
			
		}
		
		
		public Student build() {
			return new Student(this);
			
		}
		
		
		
	}
	
	
}
