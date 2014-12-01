    /*$RCSfile: validateCreditCard.js,v $ $Rev: 376673 $ $Date: 2006-02-10 13:42:31 +0000 (Fri, 10 Feb 2006) $ */
    /**
    * Check to see if fields are a valid creditcard number based on Luhn checksum.
    * Fields are not checked if they are disabled.
    * <p>
    * @param form The form validation is taking place on.
    */
    function validateCreditCard(form) {
        var bValid = true;
        var focusField = null;
        var i = 0;
        var fields = new Array();
 
        var oCreditCard = eval('new ' + jcv_retrieveFormName(form) +  '_creditCard()');

        for (var x in oCreditCard) {

            if (!jcv_verifyArrayElement(x, oCreditCard[x])) {
                continue;
            }
            var field = form[oCreditCard[x][0]];
            if (!jcv_isFieldPresent(field)) {
              continue;
            }
            if ((field.type == 'text' ||
                 field.type == 'textarea') &&
                (field.value.length > 0)) {
                if (!jcv_luhnCheck(field.value)) {
                    if (i == 0) {
                        focusField = field;
                    }
                    fields[i++] = oCreditCard[x][1];
                    bValid = false;
                }
            }
        }
        if (fields.length > 0) {
            jcv_handleErrors(fields, focusField);
        }
        return bValid;
    }

    /**
     * Checks whether a given credit card number has a valid Luhn checksum.
     * This allows you to spot most randomly made-up or garbled credit card numbers immediately.
     * Reference: http://www.speech.cs.cmu.edu/~sburke/pub/luhn_lib.html
     */
    function jcv_luhnCheck(cardNumber) {
        if (jcv_isLuhnNum(cardNumber)) {
            var no_digit = cardNumber.length;
            var oddoeven = no_digit & 1;
            var sum = 0;
            for (var count = 0; count < no_digit; count++) {
                var digit = parseInt(cardNumber.charAt(count));
                if (!((count & 1) ^ oddoeven)) {
                    digit *= 2;
                    if (digit > 9) digit -= 9;
                };
                sum += digit;
            };
            if (sum == 0) return false;
            if (sum % 10 == 0) return true;
        };
        return false;
    }

    function jcv_isLuhnNum(argvalue) {
        argvalue = argvalue.toString();
        if (argvalue.length == 0) {
            return false;
        }
        for (var n = 0; n < argvalue.length; n++) {
            if ((argvalue.substring(n, n+1) < "0") ||
                (argvalue.substring(n,n+1) > "9")) {
                return false;
            }
        }
        return true;
    }

  /**
  * This is a place holder for common utilities used across the javascript validation
  *
  **/

  /**
   * Retreive the name of the form
   * @param form The form validation is taking place on.
   */
  function jcv_retrieveFormName(form) {

      // Please refer to Bugs 31534, 35127, 35294, 37315 & 38159
      // for the history of the following code

      var formName;

      if (form.getAttributeNode) {
          if (form.getAttributeNode("id") && form.getAttributeNode("id").value) {
              formName = form.getAttributeNode("id").value;
          } else {
              formName = form.getAttributeNode("name").value;
          }
      } else if (form.getAttribute) {
          if (form.getAttribute("id")) {
              formName = form.getAttribute("id");
          } else {
              formName = form.attributes["name"];
          }
      } else {
          if (form.id) {
              formName = form.id;
          } else {
              formName = form.name;
          }
      }

      return formName;

  }  

  /**
   * Handle error messages.
   * @param messages Array of error messages.
   * @param focusField Field to set focus on.
   */
  function jcv_handleErrors(messages, focusField) {
      if (focusField && focusField != null) {
          var doFocus = true;
          if (focusField.disabled || focusField.type == 'hidden') {
              doFocus = false;
          }
          if (doFocus && 
              focusField.style && 
              focusField.style.visibility &&
              focusField.style.visibility == 'hidden') {
              doFocus = false;
          }
          if (doFocus) {
              focusField.focus();
          }
      }
      alert(messages.join('\n'));
  }

  /**
   * Checks that the array element is a valid
   * Commons Validator element and not one inserted by
   * other JavaScript libraries (for example the
   * prototype library inserts an "extends" into
   * all objects, including Arrays).
   * @param name The element name.
   * @param value The element value.
   */
  function jcv_verifyArrayElement(name, element) {
      if (element && element.length && element.length == 3) {
          return true;
      } else {
          return false;
      }
  }

  /**
   * Checks whether the field is present on the form.
   * @param field The form field.
   */
  function jcv_isFieldPresent(field) {
      var fieldPresent = true;
      if (field == null || field == undefined) {
          fieldPresent = false;
      } else {
          if (field.disabled) {
              fieldPresent = false;
          }
      }
      return fieldPresent;
  }
