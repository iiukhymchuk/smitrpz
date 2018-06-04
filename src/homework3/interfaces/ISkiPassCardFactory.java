package homework3.interfaces;

import homework3.entities.SkiPassCardOptions;

public interface ISkiPassCardFactory {
    ISkiPassCard create(SkiPassCardOptions options);
}
