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

	public static final String insertExcercise() {
		return "INSERT INTO excercise(title, description) VALUES(?, ?)";
	}

	public static final String updateExcercise() {
		return "UPDATE excercise SET title=?, description=? WHERE id=?";
	}

	public static final String deleteExcercise() {
		return "DELETE FROM excercise WHERE id=?";
	}

	public static final String selectAllExcercises() {
		return "SELECT * FROM excercise";
	}

	public static final String selectExcerciseById() {
		return "SELECT * FROM excercise WHERE id=?";
	}
	
	public static final String insertSolution() {
		return "INSERT INTO solution(created, updated, description, excercise_id, users_id) VALUES(?, ?, ?, ?, ?)";
	}
	
	public static final String updateSolution() {
		return "UPDATE solution SET created=?, updated=?, description=? excercise_id=?, user_id=? WHERE id=?";
	}
	
	public static final String deleteSolution() {
		return "DELETE FROM solution WHERE id=?";
	}
	
	public static final String selectAllSolutions() {
		return "SELECT * FROM solution";
	}
	
	public static final String selectAllSolutionsWithLimit() {
		return "SELECT * FROM solution LIMIT ?";
	}
	
	public static final String selectSolutionById() {
		return "SELECT * FROM solution WHERE id=?";
	}
	
	public static final String selectAllSolutionsByUserId() {
		return "SELECT * FROM solution WHERE users_id=?";
	}
	
	public static final String selectAllSolutionsByExcerciseId() {
		return "SELECT * FROM solution WHERE excercise_id=? ORDER BY created DESC";
	}
}
