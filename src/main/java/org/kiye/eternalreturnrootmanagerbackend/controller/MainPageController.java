package org.kiye.eternalreturnrootmanagerbackend.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.kiye.eternalreturnrootmanagerbackend.util.CustomFileUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j
@RequiredArgsConstructor
@RequestMapping("er_rootmanager/main")
public class MainPageController {

    private final CustomFileUtil customFileUtil;

    @GetMapping()
}
