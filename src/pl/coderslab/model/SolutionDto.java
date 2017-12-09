package pl.coderslab.model;

public class SolutionDto {
	private int solutionId;
	private String updated;
	private int exerciseId;
	private String title;
	private long userId;
	private String username;

	public SolutionDto(String updated, int exerciseId, String title, long userId, String username) {
		this.updated = updated;
		this.exerciseId = exerciseId;
		this.title = title;
		this.userId = userId;
		this.username = username;
	}

	public SolutionDto(int solutionId, String updated, int exerciseId, String title, long userId, String username) {
		this.solutionId = solutionId;
		this.updated = updated;
		this.exerciseId = exerciseId;
		this.title = title;
		this.userId = userId;
		this.username = username;
	}

	public int getSolutionId() {
		return solutionId;
	}

	public void setSolutionId(int solutionId) {
		this.solutionId = solutionId;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public int getExerciseId() {
		return exerciseId;
	}

	public void setExerciseId(int exerciseId) {
		this.exerciseId = exerciseId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
