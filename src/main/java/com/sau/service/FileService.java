package com.sau.service;

import com.sau.entity.FileBinding;

public interface FileService {

    FileBinding getFile(Integer id);
    boolean addFile(FileBinding fileBinding);
}
