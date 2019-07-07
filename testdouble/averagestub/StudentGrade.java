package averagestub;

public class StudentGrade {
	
	private Double oop;
	
	private Double fp;
	
	private Double db;
	
	public StudentGrade(Double oop, Double fp, Double db) {
		this.oop = oop;
		this.fp = fp;
		this.db = db;
	}
	
	public Double getOopGrade() {
		return this.oop;
	}
	public Double getFpGrade() {
		return this.fp;
	}
	public Double getDbGrade() {
		return this.db;
	}
}
