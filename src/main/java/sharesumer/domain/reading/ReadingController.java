package sharesumer.domain.reading;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/readings")
class ReadingController {

    @Autowired
    ReadingRepository readingRepository;

    @Autowired
    ReadingResourceAssembler readingResourceAssembler;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PagedResources<ReadingRepresentation> readings(@PageableDefault() Pageable pageable, PagedResourcesAssembler<Reading> assembler) {
        Page<Reading> page = readingRepository.findAll(pageable);
        return assembler.toResource(page, readingResourceAssembler);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ReadingRepresentation reading(@PathVariable String id) {
        Reading reading = readingRepository.findOne(id);
        return readingResourceAssembler.toResource(reading);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable String id) {
        readingRepository.delete(id);
    }

}

