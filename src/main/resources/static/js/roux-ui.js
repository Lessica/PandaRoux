/**
 * Created by Zheng on 23/04/2017.
 */

if (typeof jQuery !== 'undefined') {

    var lastFocusedElement = null;
    var prototypeDict = {};
    UI = {
        init: function () {
            if ($(".overlay").length <= 0) {
                $(".container-main").append('<div class="overlay" style="z-index: -999;"></div>');
            }
            $(".prototype").each(function (index) {
                var t = $(this).clone(true, true);
                t.removeClass("prototype");
                t.show();
                prototypeDict[t.attr('id')] = t;
            });
        },
        allowsUserInteraction: function (allows) {
            if (allows) {
                $(".overlay").css('z-index', -999);
                if (lastFocusedElement) {
                    lastFocusedElement.focus();
                }
                lastFocusedElement = null;
            } else {
                $(".overlay").css('z-index', 1000);
                var focused = $(':focus');
                focused.blur();
                lastFocusedElement = focused;
            }
        },
        prototype: function (prototype_name) {
            return prototypeDict[prototype_name];
        }
    };

}
