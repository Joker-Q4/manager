package com.sau.service.impl;

import com.sau.entity.FileBinding;
import com.sau.mapper.FileMapper;
import com.sau.service.FileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("fileService")
public class FileServiceImpl implements FileService {

    @Resource
    FileMapper fileMapper;

    @Override
    public FileBinding getFile(Integer id) {
        return fileMapper.findFileBindingById(id);
    }

    @Override
    public boolean addFile(FileBinding fileBinding) {
        return fileMapper.insertFileBinding(fileBinding) > 0;
    }
}
