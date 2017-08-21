package learn.online.api.service.servicemapper;

import java.util.List;

import learn.online.api.service.BaseService;
import learn.online.common.vo.StudentId;
import learn.online.common.vo.TeacherId;



public interface Viewservice extends BaseService{
	public List<StudentId> AllClasses();
	public List<TeacherId> AllTeacher();
}