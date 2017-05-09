/**
 * Created by Zheng on 23/04/2017.
 */

if (typeof jQuery !== 'undefined') {

    API = {
        getGroupList: function (callback) {
            $.ajax({
                data: {
                    "action": "get_group_list"
                },
                success: callback
            });
        },
        getGroupData: function (callback, group_id) {
            $.ajax({
                data: {
                    "action": "get_group_data",
                    "group_id": group_id
                },
                success: callback
            });
        },
        getStudentList: function (callback) {
            $.ajax({
                data: {
                    "action": "get_student_list"
                },
                success: callback
            });
        },
        selectStudent: function (callback, group_id, student_id, select_status) {
            $.ajax({
                data: {
                    "action": "select_student",
                    "group_id": group_id,
                    "student_id": student_id,
                    "select_status": select_status
                },
                success: callback
            });
        },
        createGroup: function (callback, group_name) {
            $.ajax({
                data: {
                    "action": "create_group",
                    "group_name": group_name
                },
                success: callback
            });
        },
        deleteGroup: function (callback, group_id) {
            $.ajax({
                data: {
                    "action": "delete_group",
                    "group_id": group_id
                },
                success: callback
            });
        },
        createSession: function (callback, group_id, session_name) {
            $.ajax({
                data: {
                    "action": "create_session",
                    "group_id": group_id,
                    "session_name": session_name
                },
                success: callback
            });
        },
        changeSessionDate: function (callback, session_id, session_date) {
            $.ajax({
                data: {
                    "action": "change_session_date",
                    "session_id": session_id,
                    "session_date": session_date
                },
                success: callback
            });
        },
        getSessionDetail: function (callback, session_id) {
            $.ajax({
                data: {
                    "action": "get_session_detail",
                    "session_id": session_id
                },
                success: callback
            });
        },
        editSessionDetail: function (callback, session_id, session_rate, session_comment) {
            $.ajax({
                data: {
                    "action": "edit_session_detail",
                    "session_id": session_id,
                    "session_rate": session_rate,
                    "session_comment": session_comment
                },
                success: callback
            });
        },
        deleteSession: function (callback, session_id) {
            $.ajax({
                data: {
                    "action": "delete_session",
                    "session_id": session_id
                },
                success: callback
            });
        },
        getQuestionList: function (callback) {

        }
    };

    $(function () {
        $.ajaxSetup({
            url: "//localhost:8000/api/v1", // TEST SERVER
            method: "POST",
            dataType: "json",
            timeout: 10000,
            async: true // ASYNC ??
        });
    });

}

