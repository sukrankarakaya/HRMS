package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concrate.LanguageLevel;

import java.util.List;

public interface LanguageLevelService {
    DataResult<List<LanguageLevel>> getAll();

}
