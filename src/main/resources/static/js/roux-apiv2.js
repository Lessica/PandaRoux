/**
 * Created by yerimju on 2017-04-25.
 * 
 */

if (typeof jQuery !== 'undefined') {

    APIV2 = {
        getCourseList: function (callback) {
            $.ajax({
                data: {
                    "action": "get_course_list"
                },
                success: callback
            });
        },
        getQuestionList: function (callback) {
            $.ajax({
                data: {
                    "action": "get_ques_list"
                },
                success: callback
            });
        }
    };

    $(function () {
        $.ajaxSetup({
            url: "/api/v2",
            method: "POST",
            dataType: "json",
            timeout: 10000,
            async: false // Async ??
        });
    });

}
