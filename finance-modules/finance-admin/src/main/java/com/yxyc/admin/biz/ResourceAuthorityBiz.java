package com.yxyc.admin.biz;


import com.yxyc.admin.entity.ResourceAuthority;
import com.yxyc.admin.mapper.ResourceAuthorityMapper;
import com.yxyc.common.biz.BaseBiz;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Ace on 2017/6/19.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ResourceAuthorityBiz extends BaseBiz<ResourceAuthorityMapper,ResourceAuthority> {
}
