/*import com.sda.dto.EmployeeDTO;
import com.sda.model.Employee;
import com.sda.service.EmployeeService;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ConvertEmployeeTest {
    EmployeeService employeeService = new EmployeeService();

    @Test
    public void whenConvertEmployeeToEmployeeDto(Employee employee) {
        EmployeeDTO employeeDto = new EmployeeDTO();
        employeeDto.setName(employee.getName());
        employeeDto.setAge(employee.getAge());
        employeeDto.setPosition(employee.getPosition());

        EmployeeDTO employeeDTO = employeeService(employee,EmployeeDTO.class);
        assertEquals(employee.getName(), employeeDTO.getName());
        assertEquals(employee.getAge(), employeeDTO.getAge());
        assertEquals(employee.getPosition(), employeeDTO.getPosition());

    }

    private EmployeeDTO employeeService(Employee employee, Class<EmployeeDTO> employeeDTOClass) {
        return null;
    }

}*/
