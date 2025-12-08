package com.omsu.gorch825.Application.validator;

import java.util.List;

public interface IRequestValidator<T>
{

     List<String> validate(T Object);
}
