package com.kael.coc.service;

import java.util.Map;

public interface UserService {

	Map<String, Object> getUserInfo(String platformId);

	Map<String, Object> deleteBarrier(Integer userId, String pos);
}
