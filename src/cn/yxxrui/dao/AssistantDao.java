package cn.yxxrui.dao;

import java.util.List;
import java.util.Map;

import cn.yxxrui.dto.AssistantIdForByUpdate;
import cn.yxxrui.dto.AssistantInfo;
import cn.yxxrui.model.Assistant;

public interface AssistantDao {

	public List<Assistant> getAllAssistant(Map<String, Object> map);
	public Long getTotal();
	
	public int addAssistant(Assistant assistant);
	public int deleteAssistantById(int id);
	public Assistant selectAssistantById(int id);
	public int updateAssistant(AssistantIdForByUpdate assistant);
	public AssistantIdForByUpdate getAssistantById(int assistantId);
}
