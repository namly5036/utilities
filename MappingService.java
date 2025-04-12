@Service
public class MappingService {
    @Autowired
    private ObjectMapper objectMapper;

    public <T> T convertToDto(Map<String, Object> rawResult, Class<T> dtoClass) {
        return objectMapper.convertValue(rawResult, dtoClass);
    }

    public <T> List<T> convertToDtoList(List<Map<String, Object>> rawResults, Class<T> dtoClass) {
        return rawResults.stream()
            .map(rawResult -> convertToDto(rawResult, dtoClass))
            .collect(Collectors.toList());
    }
}