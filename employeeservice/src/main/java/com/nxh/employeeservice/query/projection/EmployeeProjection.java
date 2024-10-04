package com.nxh.employeeservice.query.projection;

import com.nxh.employeeservice.command.data.Employee;
import com.nxh.employeeservice.command.data.EmployeeRepository;
import com.nxh.employeeservice.query.model.EmployeeResponseModel;
import com.nxh.employeeservice.query.queries.GetAllEmployeeQuery;
import com.nxh.employeeservice.query.queries.GetEmployeesQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeProjection {
    @Autowired
    private EmployeeRepository employeeRepository;

    @QueryHandler
    public EmployeeResponseModel handle(GetEmployeesQuery getEmployeesQuery) {
        EmployeeResponseModel model = new EmployeeResponseModel();
        Employee employee = employeeRepository.getById(getEmployeesQuery.getEmployeeId());
        BeanUtils.copyProperties(employee, model);

        return model;
    }

    @QueryHandler
    public List<EmployeeResponseModel> handle(GetAllEmployeeQuery getAllEmployeeQuery) {
        List<EmployeeResponseModel> listModel = new ArrayList<>();
        List<Employee> listEntity = employeeRepository.findAll();
        listEntity.stream().forEach(s -> {
            EmployeeResponseModel model = new EmployeeResponseModel();
            BeanUtils.copyProperties(s, model);
            listModel.add(model);
        });
        return listModel;
    }
}
