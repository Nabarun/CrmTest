	/*
	 * This command is to recommend user to follow as per salesforce recommendation api.
	 * The uniqueness of this command is it talks to the external apis like twitter, linkedin, facebook and get 
	 * more details on what is getting discussed for that user
	 */
	public class RecommendMeToFollowCommand implements RecommendUserToFollow{

		String accessToken;
		public RecommendMeToFollowCommand(String accessToken){
			this.accessToken = accessToken;
		}
		
		@Override
		public Object recommendMeToFollow() {
			RecommendUserToFollow recommender = new RecommendUser(this.accessToken);
			return recommender.recommendMeToFollow();
		}

}
