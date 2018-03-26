package cn.yxxrui.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yxxrui.dao.AssistantDao;
import cn.yxxrui.dao.ZoneDao;
import cn.yxxrui.dto.AssistantIdForByUpdate;
import cn.yxxrui.model.Assistant;
import cn.yxxrui.model.Role;
import cn.yxxrui.service.AssistantService;
@Service
public class AssistantServiceImpl implements AssistantService {

	@Resource
	AssistantDao assistantDao;
	@Resource
	ZoneDao zoneDao;
	
	@Override
	public int addAssistant(Assistant assistant) {
		int zoneId = zoneDao.getZoneIdByZoneName(assistant.getZoneName());
		assistant.setZoneId(zoneId);
		System.out.println("----zoneId----"+zoneId);
		int success = assistantDao.addAssistant(assistant);
		return success;
	}

	@Override
	public int deleteAssistantById(int id) {
		int deleteAssistantId = assistantDao.deleteAssistantById(id);
		if(deleteAssistantId>=1){
			return 1;
		}else{
			return 0;
			
		}
	}

/*	@Override
	public Assistant selectAssistantById(int id) {
		Assistant assistant= assistantDao.selectAssistantById(id);
		System.out.println("到这里了吗？？？？？？");
		System.out.println("assistant------------------------------"+assistant);
		return assistant;
	}
*/
	@Override
	public int updateAssistant(AssistantIdForByUpdate assistant) {
		    System.out.println("到这里了吗mamamammamamamamam");
			return  assistantDao.updateAssistant(assistant);
	
		}

	@Override
	public AssistantIdForByUpdate selectAssistantBYId(int assistantId) {
		System.out.println("到這里了没有呀呀呀yyyyyyyyyyyyyy");
		return assistantDao.getAssistantById(assistantId);
	}

	}

