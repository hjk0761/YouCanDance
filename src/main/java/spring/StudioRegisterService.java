package spring;

public class StudioRegisterService {
	private StudioDao studioDao;
	
	public StudioRegisterService(StudioDao studioDao) {
		this.studioDao = studioDao;
	}
	
	public Long regist(StudioRegisterRequest req) {
		Studio newstudio = new Studio(req.getName(), req.getLocate(), req.getInfo());
		studioDao.insert(newstudio);
		return newstudio.getId();
	}

}
