document.addEventListener("DOMContentLoaded", function () {

    /**
     * Form Select
     */
    class FormSelect {
        constructor($el) {
            this.$el = $el;
            this.options = [...$el.children];
            this.init();
        }

        init() {
            this.createElements();
            this.addEvents();
            this.$el.parentElement.removeChild(this.$el);
        }

        createElements() {
            // Input for value
            this.valueInput = document.createElement("input");
            this.valueInput.type = "text";
            this.valueInput.name = this.$el.name;

            // Dropdown container
            this.dropdown = document.createElement("div");
            this.dropdown.classList.add("dropdown");

            // List container
            this.ul = document.createElement("ul");

            // All list options
            this.options.forEach((el, i) => {
                const li = document.createElement("li");
                li.dataset.value = el.value;
                li.innerText = el.innerText;

                if (i === 0) {
                    // First clickable option
                    this.current = document.createElement("div");
                    this.current.innerText = el.innerText;
                    this.dropdown.appendChild(this.current);
                    this.valueInput.value = el.value;
                    li.classList.add("selected");
                }

                this.ul.appendChild(li);
            });

            this.dropdown.appendChild(this.ul);
            this.dropdown.appendChild(this.valueInput);
            this.$el.parentElement.appendChild(this.dropdown);
        }

        addEvents() {
            this.dropdown.addEventListener("click", e => {
                const target = e.target;
                this.dropdown.classList.toggle("selecting");

                // Save new value only when clicked on li
                if (target.tagName === "LI") {
                    this.valueInput.value = target.dataset.value;
                    this.current.innerText = target.innerText;
                }
            });
        }
    }

    document.querySelectorAll(".form-group--dropdown select").forEach(el => {
        new FormSelect(el);
    });

    /**
     * Hide elements when clicked on document
     */
    document.addEventListener("click", function (e) {
        const target = e.target;
        const tagName = target.tagName;

        if (target.classList.contains("dropdown")) return false;

        if (tagName === "LI" && target.parentElement.parentElement.classList.contains("dropdown")) {
            return false;
        }

        if (tagName === "DIV" && target.parentElement.classList.contains("dropdown")) {
            return false;
        }

        document.querySelectorAll(".form-group--dropdown .dropdown").forEach(el => {
            el.classList.remove("selecting");
        });
    });

    /**
     * Switching between form steps
     */
    class FormSteps {
        constructor(form) {
            this.$form = form;
            this.$next = form.querySelectorAll(".next-step");
            this.$prev = form.querySelectorAll(".prev-step");
            this.$step = form.querySelector(".form--steps-counter span");
            this.currentStep = 1;

            this.$stepInstructions = form.querySelectorAll(".form--steps-instructions p");
            const $stepForms = form.querySelectorAll("form > div");
            this.slides = [...this.$stepInstructions, ...$stepForms];

            this.init();
        }

        /**
         * Init all methods
         */
        init() {
            this.events();
            this.updateForm();
        }

        /**
         * All events that are happening in form
         */
        events() {
            // Next step
            this.$next.forEach(btn => {
                btn.addEventListener("click", e => {
                    e.preventDefault();
                    this.currentStep++;
                    this.updateForm();
                });
            });

            // Previous step
            this.$prev.forEach(btn => {
                btn.addEventListener("click", e => {
                    e.preventDefault();
                    this.currentStep--;
                    this.updateForm();
                });
            });

            // Form submit
            this.$form.querySelector("form").addEventListener("submit", e => this.submit(e));
        }

        /**
         * Update form front-end
         * Show next or previous section etc.
         */
        updateForm() {
            this.$step.innerText = this.currentStep;

            // DONE: Validation

            // STEP 1
            const checkboxes = document.querySelectorAll('input[type=checkbox]');
            const nextButton = document.getElementById('nextButton');

            checkboxes.forEach(checkbox => {
                checkbox.addEventListener('change', () => {
                    const atLeastOneChecked = Array.from(checkboxes).some(checkbox => checkbox.checked);
                    nextButton.disabled = !atLeastOneChecked;
                });
            });

            // STEP 2
            const countInput = document.getElementById('count');
            const nextButton2 = document.getElementById('nextButton2');

            countInput.addEventListener('input', () => {
                nextButton2.disabled = countInput.value === '';
            });

            // STEP 3
            const radioButtons = document.getElementsByName('institution');
            const nextButton3 = document.getElementById('nextButton3');

            for (let i = 0; i < radioButtons.length; i++) {
                radioButtons[i].addEventListener('change', () => {
                    nextButton3.disabled = false;
                });
            }

            // STEP 4
            const streetInput = document.getElementById('street');
            const cityInput = document.getElementById('city');
            const zipCodeInput = document.getElementById('zipCode');
            const phoneInput = document.getElementById('phone');

            const nextButton4 = document.getElementById('toSummary');

            [streetInput, cityInput, zipCodeInput, phoneInput].forEach(input => {
                input.addEventListener('input', () => {
                    const allFieldsFilled = streetInput.value !== ''
                                            && cityInput.value !== ''
                                            && zipCodeInput.value !== ''
                                            && phoneInput.value !== '';
                    if (allFieldsFilled) {
                        nextButton4.disabled = false;
                    } else {
                        nextButton4.disabled = true;
                    }
                });
            });



            this.slides.forEach(slide => {
                slide.classList.remove("active");

                if (slide.dataset.step == this.currentStep) {
                    slide.classList.add("active");
                }
            });

            this.$stepInstructions[0].parentElement.parentElement.hidden = this.currentStep >= 5;
            this.$step.parentElement.hidden = this.currentStep >= 5;

            // DONE: Summary

            // NUMBER OF BAGS DONATED:
            const count = document.getElementById("count").value;

            if (count == 1) {
                document.getElementById("sum-count").innerText = '1 worek zawierający ';
            } else if (count > 1 && count < 5) {
                document.getElementById("sum-count").innerText = count + ' worki zawierające ';
            } else if (count % 10 > 1 && count % 10 < 5) {
                document.getElementById("sum-count").innerText = count + ' worki zawierające ';
            } else {
                document.getElementById("sum-count").innerText = count + ' worków zawierających ';
            };

            // CATEGORIES SELECTED:
            const categories = document.getElementsByName('categories');
            categories.forEach(cat => cat.addEventListener('change', function (event) {
                cat.parentElement.children[2].toggleAttribute("selected");
            }));
            const summaryButton = document.getElementById("toSummary");
            summaryButton.addEventListener('click', function (event) {
                const categoriesSelected = document.querySelectorAll('[selected]');
                const cats = [];
                categoriesSelected.forEach(cat => cats.push(cat.innerHTML));
                const sumCategory = document.getElementById("sum-category");
                sumCategory.innerText = cats.join(', ');

            });

            // INSTITUTION SELECTED:
            const institution = document.getElementsByName("institution");
            institution.forEach(inst => inst.addEventListener('change', function (event){
                inst.parentElement.children[2].children[0].toggleAttribute("selectInst");
            }));
            summaryButton.addEventListener('click', function (event) {
                const institutionSelected = document.querySelector('[selectInst]').innerHTML;
                const sumInstitution = document.getElementById("sum-institution");
                sumInstitution.innerText = institutionSelected;
            });

            // ADDRESS AND PHONE NUMBER:
            const street = document.getElementById("street");
            const sumStreet = document.getElementById("sum-street");
            sumStreet.innerText = street.value;

            const city = document.getElementById("city");
            const sumCity = document.getElementById("sum-city");
            sumCity.innerText = city.value;

            const zip = document.getElementById("zipCode");
            const sumZip = document.getElementById("sum-zip");
            sumZip.innerText = zip.value;

            const phone = document.getElementById("phone");
            const sumPhone = document.getElementById("sum-phone");
            sumPhone.innerText = 'tel: ' + phone.value;

            // PICKUP DATE AND TIME

            const sumDate = document.getElementById("sum-date");
            sumDate.innerText = date.value;

            const time = document.getElementById("time");
            time.defaultValue = '12:30';
            const sumTime = document.getElementById("sum-time");
            sumTime.innerText = time.value;

            // DELIVERY COMMENT
            const comment = document.getElementById("comment");
            const sumComment = document.getElementById("sum-comment");
            sumComment.innerText = comment.value;

        };

    }

    const date = document.getElementById("date");
    let currentDate = new Date();
    date.valueAsDate = new Date(currentDate.getTime() + (24 * 60 * 60 * 1000));

    const form = document.querySelector(".form--steps");
    if (form !== null) {
        new FormSteps(form);
    }
});
