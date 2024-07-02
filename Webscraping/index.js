const PORT = 8000;
const axios = require('axios');
const cheerio = require('cheerio');
const express = require('express');

const app = express();
const url = "https://tjhsst.fcps.edu/staff-directory?field_last_name_from=&field_last_name_to=&items_per_page=25&keywords=&page=0";

axios.get(url)
    .then(response => {
        const html = response.data;
        const $ = cheerio.load(html);
        const articles = [];
        const Teachers = []

        $('.view__content').each(function(){
            const title = $(this).text();
            articles.push({
                title,
            });
            if(isTeacher)
                {
                    Teachers.push(title)
                }
        });
        console.log(articles);
        console.log(Teachers)
    })
    .catch(err => console.log(err));

app.listen(PORT, () => {
    console.log('Server is running on PORT ${PORT}');
});