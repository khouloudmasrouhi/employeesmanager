package com.example.employeesmanager.service;

import com.example.employeesmanager.dao.EmployeeDaoImpl;
import com.example.employeesmanager.dto.EmployeeDto;
import com.example.employeesmanager.mapper.EmployeeMapper;
import com.example.employeesmanager.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;


@Service
public class EmployeeServiceImpl implements IEmployeeService{

    private final EmployeeDaoImpl employeeDao;
    private final EmployeeMapper employeeMapper;

    private final String LOCALHOST_IPV4 = "127.0.0.1";
    private final String LOCALHOST_IPV6 = "0:0:0:0:0:0:0:1";
    private final String UNKNOWN = "unknown";

    Logger logger= LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    public EmployeeServiceImpl(EmployeeDaoImpl employeeDao, EmployeeMapper employeeMapper) {
        this.employeeDao = employeeDao;
        this.employeeMapper = employeeMapper;
    }


    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = employeeDao.addEmployee(employeeMapper.mapToEntity(employeeDto));
        return employeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public EmployeeDto update(String  id,EmployeeDto employeeDto) {

        Employee employeeRequest = employeeMapper.mapToEntity(employeeDto);
        Employee employee = employeeDao.updateEmlpoyee(id,employeeRequest);
        return employeeMapper.mapToEmployeeDto(employee);

    }

    @Override
    public EmployeeDto getById(String id) {
        return employeeMapper.mapToEmployeeDto(employeeDao.findEmployeeById(id));
    }

    @Override
    public List<EmployeeDto> getAll() {
        return employeeMapper.mapToListDto(employeeDao.findAllEmployees());

    }

    @Override
    public void delete(String id) {
        employeeDao.deleteEmployee(id);
    }

    @Override
    public String getClientIPAddress(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-Forwarded-For");
        if(!StringUtils.hasLength(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }

        if(!StringUtils.hasLength(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }

        if(!StringUtils.hasLength(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if(LOCALHOST_IPV4.equals(ipAddress) || LOCALHOST_IPV6.equals(ipAddress)) {
                try {
                    InetAddress inetAddress = InetAddress.getLocalHost();
                    ipAddress = inetAddress.getHostAddress();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
            }
        }

        if(StringUtils.hasLength(ipAddress)
                && ipAddress.length() > 5
                && ipAddress.indexOf(",") > 0) {
            ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
        }

        return ipAddress;
    }
}






















