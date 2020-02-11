package com.akki.ispdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    IspRepository ispRepository;

    @Override
    public void run(String... args) throws Exception {
        ispRepository.save(new IspEntity(1L, "ISP 1", 200f, 3.4f, 200f, "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Facilis error doloremque id beatae itaque dolor quas nesciunt dolores cupiditate deserunt.", "+91 XXXXXXXXXX", "isp@gmail.com", "https://source.unsplash.com/random/1000x300", "https://www.linkedin.com/in/akshay-tigga-796a51128/"));
        ispRepository.save(new IspEntity(2L, "ISP 2", 300f, 3.4f, 250f, "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Facilis error doloremque id beatae itaque dolor quas nesciunt dolores cupiditate deserunt.", "+91 XXXXXXXXXX", "isp@gmail.com", "https://source.unsplash.com/random/1000x300", "https://www.linkedin.com/in/akshay-tigga-796a51128/"));
        ispRepository.save(new IspEntity(3L, "ISP 3", 400f, 3.4f, 300f, "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Facilis error doloremque id beatae itaque dolor quas nesciunt dolores cupiditate deserunt.", "+91 XXXXXXXXXX", "isp@gmail.com", "https://source.unsplash.com/random/1000x300", "https://www.linkedin.com/in/akshay-tigga-796a51128/"));
        ispRepository.save(new IspEntity(4L, "ISP 4", 100f, 3.4f, 400f, "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Facilis error doloremque id beatae itaque dolor quas nesciunt dolores cupiditate deserunt.", "+91 XXXXXXXXXX", "isp@gmail.com", "https://source.unsplash.com/random/1000x300", "https://www.linkedin.com/in/akshay-tigga-796a51128/"));
        ispRepository.save(new IspEntity(5L, "ISP 5", 50f, 3.4f, 100f, "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Facilis error doloremque id beatae itaque dolor quas nesciunt dolores cupiditate deserunt.", "+91 XXXXXXXXXX", "isp@gmail.com", "https://source.unsplash.com/random/1000x300", "https://www.linkedin.com/in/akshay-tigga-796a51128/"));
        ispRepository.save(new IspEntity(6L, "ISP 6", 200f, 3.4f, 50f, "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Facilis error doloremque id beatae itaque dolor quas nesciunt dolores cupiditate deserunt.", "+91 XXXXXXXXXX", "isp@gmail.com", "https://source.unsplash.com/random/1000x300", "https://www.linkedin.com/in/akshay-tigga-796a51128/"));
    }
}

