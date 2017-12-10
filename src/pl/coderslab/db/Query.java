package pl.coderslab.db;

public class Query {

	public static final String insertUser() {
		return "INSERT INTO users(username, email, password, user_group_id) VALUES(?, ?, ?, ?)";
	}

	public static final String updateUser() {
		return "UPDATE users SET username=?, email=?, password=?, user_group_id=? WHERE id=?";
	}

	public static final String deleteUser() {
		return "DELETE FROM users WHERE id=?";
	}

	public static final String selectAllUsers() {
		return "SELECT * FROM users";
	}

	public static final String selectAllUsersByGroupId() {
		return "SELECT * FROM users WHERE user_group_id=?";
	}

	public static final String selectUserById() {
		return "SELECT * FROM users WHERE id=?";
	}

	public static final String insertGroup() {
		return "INSERT INTO user_group(name) VALUES(?)";
	}

	public static final String updateGroup() {
		return "UPDATE user_group SET name=? WHERE id=?";
	}

	public static final String deleteGroup() {
		return "DELETE FROM user_group WHERE id=?";
	}

	public static final String selectAllGroups() {
		return "SELECT * FROM user_group";
	}

	public static final String selectGroupById() {
		return "SELECT * FROM user_group WHERE id=?";
	}

	public static final String insertExercise() {
		return "INSERT INTO exercise(title, description) VALUES(?, ?)";
	}

	public static final String updateExercise() {
		return "UPDATE exercise SET title=?, description=? WHERE id=?";
	}

	public static final String deleteExercise() {
		return "DELETE FROM exercise WHERE id=?";
	}

	public static final String selectAllExercises() {
		return "SELECT * FROM exercise";
	}

	public static final String selectExerciseById() {
		return "SELECT * FROM exercise WHERE id=?";
	}

	public static final String insertSolution() {
		return "INSERT INTO solution(created, updated, description, exercise_id, users_id) VALUES(?, ?, ?, ?, ?)";
	}

	public static final String updateSolution() {
		return "UPDATE solution SET created=?, updated=?, description=?, exercise_id=?, users_id=? WHERE id=?";
	}

	public static final String deleteSolution() {
		return "DELETE FROM solution WHERE id=?";
	}

	public static final String selectAllSolutions() {
		return "SELECT * FROM solution ORDER BY updated DESC";
	}

	public static final String selectAllSolutionsWithLimit() {
		return "SELECT * FROM solution ORDER BY updated DESC LIMIT ?";
	}

	public static final String selectSolutionById() {
		return "SELECT * FROM solution WHERE id=?";
	}

	public static final String selectAllSolutionsByUserId() {
		return "SELECT * FROM solution WHERE users_id=?";
	}

	public static final String selectAllSolutionsByExerciseId() {
		return "SELECT * FROM solution WHERE exercise_id=? ORDER BY created DESC";
	}

	public static final String selectAllSolutionsUsersExercise() {
		return "SELECT users.id, users.username, exercise.id, exercise.title, solution.id, solution.updated"
				+ " FROM users JOIN solution ON users.id=solution.users_id"
				+ " JOIN exercise ON exercise.id=solution.exercise_id ORDER BY updated DESC";
	}
	
	public static final String selectAllSolutionsDtoWithLimit() {
		return "SELECT users.id, users.username, exercise.id, exercise.title, solution.id, solution.updated"
				+ " FROM users JOIN solution ON users.id=solution.users_id"
				+ " JOIN exercise ON exercise.id=solution.exercise_id ORDER BY updated DESC LIMIT ?";
	}
	
	public static final String selectAllSolutionsDtoByUserId() {
		return "SELECT users.id, users.username, exercise.id, exercise.title, solution.id, solution.updated"
				+ " FROM users JOIN solution ON users.id=solution.users_id"
				+ " JOIN exercise ON exercise.id=solution.exercise_id WHERE users.id=? ORDER BY updated";
	}
	
	public static final String selectAllSolutionsDtoByExerciseId() {
		return "SELECT users.id, users.username, exercise.id, exercise.title, solution.id, solution.updated"
				+ " FROM users JOIN solution ON users.id=solution.users_id"
				+ " JOIN exercise ON exercise.id=solution.exercise_id WHERE exercise.id=? ORDER BY updated";
	}
	
}
