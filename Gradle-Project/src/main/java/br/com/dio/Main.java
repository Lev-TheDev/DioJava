package br.com.dio;

import br.com.dio.dto.UserDTO;
import br.com.dio.mapper.UserMapper;
import br.com.dio.model.UserModel;
import org.mapstruct.factory.Mappers;

public class Main {
    private static final UserMapper mapper = Mappers.getMapper(UserMapper.class);

    public static void main(String[] args) {
        var model = new UserModel();
        model.setCode(1);
        model.setUserName("John Doe");
        model.setBirthdate(java.time.LocalDate.of(1990, 1, 1));
        System.out.println(mapper.toDTO(model));

        var dto = new UserDTO();
        dto.setId(2);
        dto.setName("Jane Smith");
        dto.setBirthdate(java.time.LocalDate.of(1992, 2, 2));
        System.out.println(mapper.toModel(dto));

        }
}
