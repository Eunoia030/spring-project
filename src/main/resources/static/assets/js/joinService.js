const joinService = (function () {

    function checkDuplication(inputData, callback) {
        $.ajax({
            url: "/user/checkId",
            type: "post",
            data: {inputData: inputData},
            async: false,
            success: function(result){
                if(callback){
                    callback(result);
                }
            }
        });
    }

    return {checkDuplication : checkDuplication}
})();
