package cn.yxxrui.service;

import cn.yxxrui.dto.AssistantIdForByUpdate;
import cn.yxxrui.model.Assistant;

public interface AssistantService {

	public int addAssistant(Assistant assistant);
	public int deleteAssistantById(int id);
	public AssistantIdForByUpdate selectAssistantBYId(int assistantId);
	public int updateAssistant(AssistantIdForByUpdate assistant);
}
