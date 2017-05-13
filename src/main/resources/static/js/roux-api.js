/**
 * Created by Zheng on 23/04/2017.
 *
 */

if (typeof jQuery !== 'undefined') {

    API = {
        loginCheck: function(callback, username, password) {
            $.ajax("/loginCheck", {
                method: "POST",
                data: {
                    "login": username,
                    "password": password
                },
                success: callback
            });
        },
        getGroupList: function (callback) {
            $.ajax({
                data: {
                    "action": "get_group_list"
                },
                success: callback
            });
        },
        /*
        {
            "group_list": [
                {"id": 1, "name": "Herakles Forecited"}, {"id": 2, "name": "Dompt Navarrese"},
                {"id": 3, "name": "Monistically Cimmerian"}, {"id": 4, "name": "Alginuresis Mispleading"},
                {"id": 5, "name": "Tribesman Scopiform"}, {"id": 6, "name": "Anteroposteriorly Brucine"},
                {"id": 7, "name": "Housemaster Agilely"}, {"id": 8, "name": "Superficialness Hesthogenous"},
                {"id": 9, "name": "Roughdry Volsci"}, {"id": 10, "name": "Gelototherapy Ploughtail"},
                {"id": 11, "name": "Amahuaca Rodger"}
            ]
        }
         */
        getGroupData: function (callback, group_id) {
            $.ajax({
                data: {
                    "action": "get_group_data",
                    "group_id": group_id
                },
                success: callback
            });
        },
        /*
            {"id": group_id, "selected_student": [
                    {"id": 10000, "name": "Herbert Pratt"}, {"id": 10001, "name": "Alma Salazar"},
                    {"id": 10012, "name": "Gordon Pena"}, {"id": 10013, "name": "Fred Shaw"},
                    {"id": 10048, "name": "Dwayne Robinson"}, {"id": 10049, "name": "Edward Brady"},
                ], "session_list": [
                {
                    "id": 1,
                    "name": "Session 1",
                    "date": "25/04/2017",
                    "rate": 5,
                    "comment": "Hello, world!"
                },
                {
                    "id": 2,
                    "name": "Session 2",
                    "date": "18/04/2017",
                    "rate": 5,
                    "comment": "Hello, world!"
                },
                {
                    "id": 3,
                    "name": "Session 3",
                    "date": "11/04/2017",
                    "rate": 5,
                    "comment": "Hello, world!"
                },
                {
                    "id": 4,
                    "name": "Session 4",
                    "date": "04/04/2017",
                    "rate": 5,
                    "comment": "Hello, world!"
                },
                {
                    "id": 5,
                    "name": "Session 5",
                    "date": "26/03/2017",
                    "rate": 5,
                    "comment": "Hello, world!"
                },
                {
                    "id": 6,
                    "name": "Session 6",
                    "date": "19/03/2017",
                    "rate": 5,
                    "comment": "Hello, world!"
                },
                {
                    "id": 7,
                    "name": "Session 7",
                    "date": "12/03/2017",
                    "rate": 5,
                    "comment": ""
                },
                {
                    "id": 8,
                    "name": "Session 8",
                    "date": "05/03/2017",
                    "rate": 5,
                    "comment": ""
                }
            ]}
         */
        getStudentList: function (callback) {
            $.ajax({
                data: {
                    "action": "get_student_list"
                },
                success: callback
            });
        },
        /*
        {
            "student_list": [
                {"id": 10000, "name": "Herbert Pratt"}, {"id": 10001, "name": "Alma Salazar"},
                {"id": 10002, "name": "Phil Gross"}, {"id": 10003, "name": "Fredrick Clark"},
                {"id": 10004, "name": "Max Figueroa"}, {"id": 10005, "name": "Peggy Cole"},
                {"id": 10006, "name": "Antoinette Garrett"}, {"id": 10007, "name": "Christopher Rivera"},
                {"id": 10008, "name": "Charlie Cross"}, {"id": 10009, "name": "Roy Potter"},
                {"id": 10010, "name": "Elijah Kim"}, {"id": 10011, "name": "Troy Schwartz"},
                {"id": 10012, "name": "Gordon Pena"}, {"id": 10013, "name": "Fred Shaw"},
                {"id": 10014, "name": "Eula Oliver"}, {"id": 10015, "name": "Casey Henry"},
                {"id": 10016, "name": "Roman Carroll"}, {"id": 10017, "name": "Tracy Russell"},
                {"id": 10018, "name": "Opal Osborne"}, {"id": 10019, "name": "Rick Owens"},
                {"id": 10020, "name": "Gayle Munoz"}, {"id": 10021, "name": "Darin Cobb"},
                {"id": 10022, "name": "Virginia Page"}, {"id": 10023, "name": "Emilio Harris"},
                {"id": 10024, "name": "Anne Wong"}, {"id": 10025, "name": "Cornelius Ryan"},
                {"id": 10026, "name": "Bethany Bradley"}, {"id": 10027, "name": "Susie Erickson"},
                {"id": 10028, "name": "Edna Mills"}, {"id": 10029, "name": "Leonard Welch"},
                {"id": 10030, "name": "Danny Wright"}, {"id": 10031, "name": "Kay Garner"},
                {"id": 10032, "name": "Olga Crawford"}, {"id": 10033, "name": "Carlos Harrington"},
                {"id": 10034, "name": "Minnie Turner"}, {"id": 10035, "name": "Jerald Francis"},
                {"id": 10036, "name": "Kenneth Ball"}, {"id": 10037, "name": "Jackie Stokes"},
                {"id": 10038, "name": "Leona King"}, {"id": 10039, "name": "Ramona Lopez"},
                {"id": 10040, "name": "Clifford Carpenter"}, {"id": 10041, "name": "Blanche Dunn"},
                {"id": 10042, "name": "Brendan Conner"}, {"id": 10043, "name": "Bertha Washington"},
                {"id": 10044, "name": "Sandy Waters"}, {"id": 10045, "name": "Jessica Fisher"},
                {"id": 10046, "name": "Georgia Lucas"}, {"id": 10047, "name": "Scott Kelley"},
                {"id": 10048, "name": "Dwayne Robinson"}, {"id": 10049, "name": "Edward Brady"},
                {"id": 10050, "name": "Calvin Hicks"}, {"id": 10051, "name": "Shane Parker"},
                {"id": 10052, "name": "Andrew Higgins"}, {"id": 10053, "name": "Bert Patton"},
                {"id": 10054, "name": "Virgil Diaz"}, {"id": 10055, "name": "Carla Poole"},
                {"id": 10056, "name": "Agnes Hernandez"}, {"id": 10057, "name": "Lindsey Mcdaniel"},
                {"id": 10058, "name": "Julie Mack"}, {"id": 10059, "name": "Bonnie Vega"},
                {"id": 10060, "name": "Marian Hopkins"}, {"id": 10061, "name": "Erik Jones"},
                {"id": 10062, "name": "Latoya Watts"}, {"id": 10063, "name": "Brandi Howard"},
                {"id": 10064, "name": "Dianne Ferguson"}, {"id": 10065, "name": "Shelley Ortega"},
                {"id": 10066, "name": "Al Weber"}, {"id": 10067, "name": "Neil Stewart"},
                {"id": 10068, "name": "Frances Wagner"}, {"id": 10069, "name": "Tammy Moran"},
                {"id": 10070, "name": "Yvette Dennis"}, {"id": 10071, "name": "Tasha Barrett"},
                {"id": 10072, "name": "Madeline Carlson"}, {"id": 10073, "name": "Christine Ross"},
                {"id": 10074, "name": "Beatrice Miles"}, {"id": 10075, "name": "Irvin Wise"},
                {"id": 10076, "name": "Vanessa Wood"}, {"id": 10077, "name": "Kerry Hardy"},
                {"id": 10078, "name": "Joey Watson"}, {"id": 10079, "name": "Earl Hunter"},
                {"id": 10080, "name": "Jose Owen"}, {"id": 10081, "name": "Tina Mullins"},
                {"id": 10082, "name": "Sherman Payne"}, {"id": 10083, "name": "Eric Herrera"},
                {"id": 10084, "name": "Lester Hubbard"}, {"id": 10085, "name": "Angelina Rice"},
                {"id": 10086, "name": "Brenda Martinez"}, {"id": 10087, "name": "Eunice Fowler"},
                {"id": 10088, "name": "Regina Chambers"}, {"id": 10089, "name": "Perry Houston"},
                {"id": 10090, "name": "Abraham Moody"}, {"id": 10091, "name": "Darrel Hines"},
                {"id": 10092, "name": "Kenny Schultz"}, {"id": 10093, "name": "Reginald Nguyen"},
                {"id": 10094, "name": "Sharon Morales"}, {"id": 10095, "name": "Ronnie Swanson"},
                {"id": 10096, "name": "Katherine Matthews"}, {"id": 10097, "name": "Daryl Hampton"},
                {"id": 10098, "name": "Mack Dawson"}, {"id": 10099, "name": "Alonzo Peters"}
            ]
        }
         */
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
        /*
        {
            "result": "succeed",
            "student": {"id": 10098, "name": "Mack Dawson"}
        }
         */
        createGroup: function (callback, group_name) {
            $.ajax({
                data: {
                    "action": "create_group",
                    "group_name": group_name
                },
                success: callback
            });
        },
        /*
        {
            "result": "succeed",
            "group": {
                "id": group_id,
                "name": group_name
            }
        }
         */
        deleteGroup: function (callback, group_id) {
            $.ajax({
                data: {
                    "action": "delete_group",
                    "group_id": group_id
                },
                success: callback
            });
        },
        /*
        {
            "result": "succeed",
            "group": {
                "id": group_id
            }
        }
         */
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
        /*
        {
            "result": "succeed",
            "session": {
                "id": session_id,
                "name": session_name,
                "date": "",
                "rate": 5,
                "comment": ""
            }
        }
         */
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
        /*
        {
            "result": "succeed",
            "session": {
                "id": session_id,
                "name": "",
                "date": session_date,
                "rate": 5,
                "comment": ""
            }
        }
         */
        getSessionDetail: function (callback, session_id) {
            $.ajax({
                data: {
                    "action": "get_session_detail",
                    "session_id": session_id
                },
                success: callback
            });
        },
        /*
        {
            "id": session_id,
            "name": "Session " + str(session_id),
            "date": "",
            "rate": 4,
            "comment": "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
        }
         */
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
        /*
        {
            "result": "error",
            "error": "The comment is too long (> 1024 chars)."
        }
         */
        deleteSession: function (callback, session_id) {
            $.ajax({
                data: {
                    "action": "delete_session",
                    "session_id": session_id
                },
                success: callback
            });
        },
        /*
        {
            "result": "succeed",
            "session": {
                "id": session_id
            }
        }
         */
        getQuestionList: function (callback) {
            $.ajax({
                data: {
                    "action": "get_question_list"
                },
                success: callback
            });
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

