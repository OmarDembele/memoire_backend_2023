package com.esmt.memoire_back2023.services;

import com.esmt.memoire_back2023.dto.AdminDTO;
import com.esmt.memoire_back2023.entity.Admin;

public interface AdminService {

    Admin creerAdmin(AdminDTO adminDTO);

    void deleteAdmin(Long id);

    Admin updateAdmin(Long id,AdminDTO adminDTO);

}
