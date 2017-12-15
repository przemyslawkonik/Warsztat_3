package pl.coderslab.db;

public class Query {

	public static String insertGroup() {
		return "INSERT INTO group(name) VALUES(?)";
	}

	public static String updateGroup() {
		return "UPDATE group SET name=? WHERE id=?";
	}

	public static String deleteGroup() {
		return "DELETE FROM group WHERE id=?";
	}

	public static String selectAllGroups() {
		return "SELECT * FROM group";
	}

	public static String selectGroupById() {
		return "SELECT * FROM group WHERE id=?";
	}



	public static String insertUser() {
		return "INSERT INTO user(username, email, password, group_id) VALUES(?, ?, ?, ?)";
	}

	public static String updateUser() {
		return "UPDATE user SET username=?, email=?, password=?, group_id=? WHERE id=?";
	}

	public static String deleteUser() {
		return "DELETE FROM user WHERE id=?";
	}

	public static String selectAllUsers() {
		return "SELECT * FROM user";
	}

	public static String selectAllUsersByGroupId() {
		return "SELECT * FROM user WHERE group_id=?";
	}

	public static String selectUserById() {
		return "SELECT * FROM user WHERE id=?";
	}

	public static String insertExercise() {
		return "INSERT INTO exercise(title, description) VALUES(?, ?)";
	}

	public static String updateExercise() {
		return "UPDATE exercise SET title=?, description=? WHERE id=?";
	}

	public static String deleteExercise() {
		return "DELETE FROM exercise WHERE id=?";
	}

	public static String selectAllExercises() {
		return "SELECT * FROM exercise";
	}

	public static String selectExerciseById() {
		return "SELECT * FROM exercise WHERE id=?";
	}

	public static String insertSolution() {
		return "INSERT INTO solution(created, updated, description, exercise_id, user_id) VALUES(?, ?, ?, ?, ?)";
	}

	public static String updateSolution() {
		return "UPDATE solution SET created=?, updated=?, description=?, exercise_id=?, user_id=? WHERE id=?";
	}

	public static String deleteSolution() {
		return "DELETE FROM solution WHERE id=?";
	}

	public static String selectAllSolutions() {
		return "SELECT * FROM solution ORDER BY updated DESC";
	}

	public static String selectAllSolutionsWithLimit() {
		return "SELECT * FROM solution ORDER BY updated DESC LIMIT ?";
	}

	public static String selectSolutionById() {
		return "SELECT * FROM solution WHERE id=?";
	}

	public static String selectAllSolutionsByUserId() {
		return "SELECT * FROM solution WHERE user_id=?";
	}

	public static String selectAllSolutionsByExerciseId() {
		return "SELECT * FROM solution WHERE exercise_id=? ORDER BY created DESC";
	}

	public static String selectAllSolutionsDto() {
		return "SELECT user.id, user.username, exercise.id, exercise.title, solution.id, solution.updated"
				+ " FROM user JOIN solution ON user.id=solution.user_id"
				+ " JOIN exercise ON exercise.id=solution.exercise_id ORDER BY updated DESC";
	}
	
	public static String selectAllSolutionsDtoWithLimit() {
		return "SELECT user.id, user.username, exercise.id, exercise.title, solution.id, solution.updated"
				+ " FROM user JOIN solution ON user.id=solution.user_id"
				+ " JOIN exercise ON exercise.id=solution.exercise_id ORDER BY updated DESC LIMIT ?";
	}
	
	public static String selectAllSolutionsDtoByUserId() {
		return "SELECT user.id, user.username, exercise.id, exercise.title, solution.id, solution.updated"
				+ " FROM user JOIN solution ON users.id=solution.user_id"
				+ " JOIN exercise ON exercise.id=solution.exercise_id WHERE user.id=? ORDER BY updated";
	}
	
	public static String selectAllSolutionsDtoByExerciseId() {
		return "SELECT user.id, user.username, exercise.id, exercise.title, solution.id, solution.updated"
				+ " FROM user JOIN solution ON user.id=solution.user_id"
				+ " JOIN exercise ON exercise.id=solution.exercise_id WHERE exercise.id=? ORDER BY updated";
	}
	
}
