package com.zelys.conversordemoneda.logica;

public record ConversorER(String base_code,
                          String target_code,
                          double conversion_rate,
                          double conversion_result
) {
}
